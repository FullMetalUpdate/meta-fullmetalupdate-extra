# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "OCI container including the QT Electrical Vehicle Charging Station project and its dependencies"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

IMAGE_INSTALL = " \
    evcs \
    qtlocation \
    qtvirtualkeyboard \
    qtmultimedia \
    fontconfig \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
"

# Container start up file
CONTAINER_STARTUP= "${THISDIR}/files/entry.sh"
# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/qt-evcs-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/container-qt-evcs.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "1"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update
AUTOREMOVE = "0"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "1"

inherit fullmetalupdate_package_container_image
inherit fullmetalupdate_push_container_to_ostree