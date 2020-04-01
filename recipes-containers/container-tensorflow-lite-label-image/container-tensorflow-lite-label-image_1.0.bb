# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "OCI container including Tensorflow Lite and an example of deep learning network for image classification"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

include ${PN}_${MACHINE}.inc

IMAGE_INSTALL = " \
    tensorflow-lite \
    tensorflow-lite-staticdev \
    tensorflow-lite-examples \
    busybox \
"

# Container start up file
CONTAINER_STARTUP= "${THISDIR}/files/entry.sh"
# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/tensorflow-lite-label-image-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/container-tensorflow-lite-label-image.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "0"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update of the container
AUTOREMOVE = "0"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "0"

inherit fullmetalupdate_package_container_image
inherit fullmetalupdate_push_container_to_ostree
