# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WIC_CREATE_EXTRA_ARGS_append = " --no-fstab-update "

# We override the kernel device tree so that only one is shipped in the update. This
# avoids an issue where ostree selects the wrong device tree because there are multiple
# device trees defined in the conf of the machine.
KERNEL_DEVICETREE = "imx8mq-evk.dtb"
