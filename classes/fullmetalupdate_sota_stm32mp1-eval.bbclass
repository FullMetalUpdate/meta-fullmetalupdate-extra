# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)


#see imx-base.inc - soft assignment not used when defining it here
IMAGE_BOOT_FILES_sota += ""

OSTREE_BOOTLOADER ?= "u-boot"

OSTREE_KERNEL_ARGS ?= "rw rootwait"

IMAGE_FSTYPES_remove_sota = "garagesign garagecheck"

PREFERRED_PROVIDER_virtual/bootloader_sota ?= "u-boot-stm32mp_2018.11"
