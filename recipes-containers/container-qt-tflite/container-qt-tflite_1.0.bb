# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "OCI container including the TensorFlow Lite and Qt/QML: object detection example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

include ${PN}_${MACHINE}.inc

IMAGE_INSTALL = " \
    qt-tflite \
    qt-tflite-tools \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsensors \
    fontconfig \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-rtsp-server-meta \
"

# Container start up file
CONTAINER_STARTUP= "${THISDIR}/files/entry.sh"
# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/qt-tflite-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/container-qt-tflite.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "1"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update
AUTOREMOVE = "0"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "1"



inherit fullmetalupdate_package_container_image
inherit fullmetalupdate_push_container_to_ostree