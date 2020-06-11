# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
wIC_CREATE_EXTRA_ARGS_append = " --no-fstab-update "

IMAGE_INSTALL_append = " \
    kernel-module-imx-gpu-viv \
"

# We override the kernel device tree so that only one is shipped in the update. This
# avoids an issue where ostree selects the wrong device tree because there are multiple
# device trees defined in the conf of the machine.
KERNEL_DEVICETREE = "imx8mq-evk.dtb"
