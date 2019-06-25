# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)


#see imx-base.inc - soft assignment not used when defining it here
IMAGE_BOOT_FILES_sota += "KERNEL_IMAGE UBOOT_IMAGE DTS_FILES"

OSTREE_BOOTLOADER ?= "u-boot"

OSTREE_KERNEL_ARGS ?= "rw rootwait"

IMAGE_FSTYPES_remove_sota = "garagesign garagecheck"
