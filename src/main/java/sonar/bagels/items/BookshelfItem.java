package sonar.bagels.items;

import mcmultipart.item.ItemMultiPart;
import mcmultipart.multipart.IMultipart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import sonar.bagels.parts.Bookshelf;
import sonar.bagels.parts.DeskMultipart;

public class BookshelfItem extends ItemMultiPart {

	public boolean place(World world, BlockPos pos, EnumFacing side, Vec3d hit, ItemStack stack, EntityPlayer player) {
		if (!player.canPlayerEdit(pos, side, stack))
			return false;

		DeskMultipart desk = DeskMultipart.getDeskPart(world, pos);
		return desk == null ? false : super.place(world, pos, side, hit, stack, player);
	}

	@Override
	public IMultipart createPart(World world, BlockPos pos, EnumFacing side, Vec3d hit, ItemStack stack, EntityPlayer player) {
		return new Bookshelf(player.getHorizontalFacing().getOpposite());
	}

}
