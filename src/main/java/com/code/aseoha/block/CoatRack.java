package com.code.aseoha.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class CoatRack extends Block {
    public CoatRack(Properties props) {
        super(props);
    }

    public static VoxelShape SHAPE = createVoxelShape();

    public static VoxelShape createVoxelShape() {
        return Stream.of(
                Block.box(5.499999999999998, 0, 7.499999999999998, 6.499999999999998, 1, 8.499999999999998),
                Block.box(6, 1, 7.499999999999998, 7, 2, 8.499999999999998),
                Block.box(6.499999999999998, 2, 7.499999999999998, 7.499999999999998, 3, 8.499999999999998),
                Block.box(6.899999999999997, 3, 7.499999999999998, 7.899999999999997, 4, 8.499999999999998),
                Block.box(7.499999999999998, 3, 8.100000000000003, 8.499999999999998, 4, 9.100000000000003),
                Block.box(7.499999999999998, 0, 9.500000000000002, 8.499999999999998, 1, 10.500000000000002),
                Block.box(7.499999999999998, 1, 9, 8.499999999999998, 2, 10),
                Block.box(7.499999999999998, 2, 8.500000000000002, 8.499999999999998, 3, 9.500000000000002),
                Block.box(8.100000000000003, 3, 7.500000000000002, 9.100000000000003, 4, 8.500000000000002),
                Block.box(9.500000000000002, 0, 7.500000000000002, 10.500000000000002, 1, 8.500000000000002),
                Block.box(9, 1, 7.500000000000002, 10, 2, 8.500000000000002),
                Block.box(8.500000000000002, 2, 7.500000000000002, 9.500000000000002, 3, 8.500000000000002),
                Block.box(7.500000000000002, 3, 6.899999999999997, 8.500000000000002, 4, 7.899999999999997),
                Block.box(7.500000000000002, 0, 5.499999999999998, 8.500000000000002, 1, 6.499999999999998),
                Block.box(7.500000000000002, 1, 6, 8.500000000000002, 2, 7),
                Block.box(7.500000000000002, 2, 6.499999999999998, 8.500000000000002, 3, 7.499999999999998),
                Block.box(7.499999999999995, 4, 7.499999999999998, 8.499999999999995, 26, 8.499999999999998),
                Block.box(7.499999999999995, 22.300000000000004, 8.499999999999998, 8.499999999999995, 23.300000000000004, 9.499999999999998),
                Block.box(7.499999999999995, 23.30000000000001, 9.299999999999999, 8.499999999999995, 24.30000000000001, 10.299999999999999),
                Block.box(7.499999999999995, 24.200000000000024, 10.2, 8.499999999999995, 25.200000000000024, 11.2),
                Block.box(7.499999999999995, 25.00000000000002, 11, 8.499999999999995, 26.00000000000002, 12),
                Block.box(6.499999999999995, 22, 7.499999999999998, 7.499999999999995, 23, 8.499999999999998),
                Block.box(5.499999999999995, 22.60000000000001, 7.499999999999998, 6.499999999999995, 23.60000000000001, 8.499999999999998),
                Block.box(4.499999999999995, 22.900000000000013, 7.499999999999998, 5.499999999999995, 23.900000000000013, 8.499999999999998),
                Block.box(3.4999999999999947, 23.30000000000002, 7.499999999999998, 4.499999999999995, 24.30000000000002, 8.499999999999998),
                Block.box(2.4999999999999947, 23.800000000000026, 7.499999999999998, 3.4999999999999947, 24.800000000000026, 8.499999999999998),
                Block.box(7.499999999999995, 22.30000000000002, 6.499999999999998, 8.499999999999995, 23.30000000000002, 7.499999999999998),
                Block.box(7.499999999999995, 23.200000000000035, 6.099999999999996, 8.499999999999995, 24.200000000000035, 7.099999999999996),
                Block.box(7.499999999999995, 24.20000000000005, 5.6999999999999975, 8.499999999999995, 25.20000000000005, 6.6999999999999975),
                Block.box(7.499999999999995, 26.200000000000077, 4.9, 8.499999999999995, 27.200000000000077, 5.9),
                Block.box(7.499999999999995, 25.200000000000063, 5.299999999999999, 8.499999999999995, 26.200000000000063, 6.299999999999999),
                Block.box(8.499999999999995, 21.500000000000007, 7.499999999999998, 9.499999999999995, 22.500000000000007, 8.499999999999998),
                Block.box(9.499999999999995, 22.500000000000007, 7.499999999999998, 10.499999999999995, 23.500000000000007, 8.499999999999998),
                Block.box(10.499999999999995, 23.500000000000007, 7.499999999999998, 11.499999999999995, 24.500000000000007, 8.499999999999998),
                Block.box(11.499999999999995, 24.500000000000007, 7.499999999999998, 12.499999999999995, 25.500000000000007, 8.499999999999998)
        ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState state, @NotNull IBlockReader worldIn, @NotNull BlockPos pos, @NotNull ISelectionContext context) {
        return SHAPE;
    }
}