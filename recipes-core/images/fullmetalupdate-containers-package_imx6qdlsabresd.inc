# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
PREINSTALLED_CONTAINERS_LIST_append = "container-tensorflow-lite-label-image"

PACKAGECONFIG_remove-pn-qtbase = "x11 xcb xkb xkbcommon-evdev"

IMAGE_ROOTFS_EXTRA_SPACE = "202173"
