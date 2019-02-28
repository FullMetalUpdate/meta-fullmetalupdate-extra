# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "A minimal image containing busybox"
LICENSE = "CLOSED"

IMAGE_INSTALL = " \
    container-qt-evcs \
    qtquickcontrols \
    qtquickcontrols2 \
    qtdeclarative \
    qtlocation \
    qtvirtualkeyboard \
    qtmultimedia \
    qtquickcontrols2-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtdeclarative-qmlplugins \
"

# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/qt-evcs-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/qt-evcs-container.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "1"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update
AUTOREMOVE = "0"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "1"

inherit wiupdate_package_container_image
inherit wiupdate_push_container_to_ostree
