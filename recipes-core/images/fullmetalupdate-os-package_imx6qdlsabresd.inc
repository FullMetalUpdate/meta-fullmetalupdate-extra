# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WIC_CREATE_EXTRA_ARGS_append = "--no-fstab-update "

IMAGE_INSTALL_append = " \
    kernel-module-imx-gpu-viv \
"
