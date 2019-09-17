# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)


#see imx-base.inc - soft assignment not used when defining it here
IMAGE_BOOT_FILES_sota += "stm32mp1-bootfiles/* \
						stm32mp157c-ev1.dtb \
						zImage"

OSTREE_BOOTLOADER ?= "u-boot"

OSTREE_KERNEL_ARGS ?= "ostree_root=/dev/mmcblk0p5 rootwait rw console=ttySTM0,115200"

IMAGE_FSTYPES_remove_sota = "garagesign garagecheck"

SOTA_MAIN_DTB_stm32mp1-eval ?= "stm32mp157c-ev1.dtb"

INITRAMFS_FSTYPES = 'cpio.gz.u-boot'
