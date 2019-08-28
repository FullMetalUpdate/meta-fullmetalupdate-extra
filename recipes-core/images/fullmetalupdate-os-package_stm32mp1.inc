# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WIC_CREATE_EXTRA_ARGS_append = "--no-fstab-update "

ENABLE_FLASHLAYOUT_CONFIG = "0"
ENABLE_PARTITIONS_IMAGE = "0"

DEPENDS += "stm32mp1-bootfiles"