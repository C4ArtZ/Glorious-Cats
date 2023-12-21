package de.c4artz.glorious_cats.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.io.DataInput;
import java.util.stream.Stream;

public class Olivia extends HorizontalFacingBlock {

	public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

	public Olivia(Settings settings) {
		super(settings);
	}

//	private static VoxelShape SHAPE = Block.createCuboidShape(4,0,0,13,6,16);

	private static final VoxelShape SHAPE_N = Stream.of(
		Block.createCuboidShape(6, 0, 1, 10, 6, 17),
		Block.createCuboidShape(5.5, 0, -4, 10.5, 4, 1),
		Block.createCuboidShape(6.5, 0, -5, 9.5, 2, -3),
		Block.createCuboidShape(9, 4, -1, 10, 5, 1),
		Block.createCuboidShape(6, 4, -1, 7, 5, 1)
	).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

	private static final VoxelShape SHAPE_E = Stream.of(
		Block.createCuboidShape(-1, 0, 6, 15, 6, 10),
		Block.createCuboidShape(15, 0, 5.5, 20, 4, 10.5),
		Block.createCuboidShape(19, 0, 6.5, 21, 2, 9.5),
		Block.createCuboidShape(15, 4, 9, 17, 5, 10),
		Block.createCuboidShape(15, 4, 6, 17, 5, 7)
	).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

	private static final VoxelShape SHAPE_S = Stream.of(
		Block.createCuboidShape(6, 0, -1, 10, 6, 15),
		Block.createCuboidShape(5.5, 0, 15, 10.5, 4, 20),
		Block.createCuboidShape(6.5, 0, 19, 9.5, 2, 21),
		Block.createCuboidShape(6, 4, 15, 7, 5, 17),
		Block.createCuboidShape(9, 4, 15, 10, 5, 17)
	).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

	private static final VoxelShape SHAPE_W = Stream.of(
		Block.createCuboidShape(1, 0, 6, 17, 6, 10),
		Block.createCuboidShape(-4, 0, 5.5, 1, 4, 10.5),
		Block.createCuboidShape(-5, 0, 6.5, -3, 2, 9.5),
		Block.createCuboidShape(-1, 4, 6, 1, 5, 7),
		Block.createCuboidShape(-1, 4, 9, 1, 5, 10)
	).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		switch (state.get(FACING)) {
			case NORTH:
				return SHAPE_N;
			case EAST:
				return SHAPE_E;
			case SOUTH:
				return SHAPE_S;
			case WEST:
				return SHAPE_W;
			default:
				return SHAPE_N;
		}
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return state.rotate(mirror.getRotation(state.get(FACING)));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
	builder.add(FACING);
	}
}
