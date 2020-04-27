# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)

EXTRA_IMAGEDEPENDS_append_sota = " imx-bootfiles"

#see imx-base.inc - soft assignment not used when defining it here
IMAGE_BOOT_FILES_sota += "imx-bootfiles/* \
    ${KERNEL_IMAGETYPE} \
    ${@make_dtb_boot_files(d)} \
"

OSTREE_BOOTLOADER ?= "u-boot"

OSTREE_KERNEL_ARGS ?= "rw rootwait console=ttymxc0,115200"

IMAGE_FSTYPES_remove_sota = "garagesign garagecheck"

INITRAMFS_FSTYPES = 'cpio.gz.u-boot'
