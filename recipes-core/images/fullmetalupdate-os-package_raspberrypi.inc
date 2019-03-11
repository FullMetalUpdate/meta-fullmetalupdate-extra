# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WIC_CREATE_EXTRA_ARGS_append = "--no-fstab-update "

DEPENDS += "bcm2835-bootfiles"

IMAGE_INSTALL_append = " \
    userland \
"

IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"
