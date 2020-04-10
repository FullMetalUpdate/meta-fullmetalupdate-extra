# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "OCI Container including busybox and a sh script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"

include ${PN}_${MACHINE}.inc

SRC_URI = " \
    file://${PN}.service \
    file://entry.sh \
    file://sd-notify-config.json \
"

IMAGE_INSTALL = " \
    busybox \
    systemd \
    dbus-glib \
"

# Container start up file
CONTAINER_STARTUP= "${THISDIR}/files/entry.sh"
# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/sd-notify-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/container-sd-notify.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "1"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update of the container
AUTOREMOVE = "0"

# The NOTIFY variable should be set for containers that implement the notify feature of systemd.
# The FullMetalUpdate client will rollback the container depending on the result of the
# container execution.
# TIMEOUT is a required value when NOTIFY is set to 1. It represents a delay (seconds) for
# which the client will wait and ultimately feedback the server in case the container has
# failed in a way the client did not predict. Set this variable larger than
# TimeoutStartDelay= in the service file.
# AUTOSTART must be set to 1 when NOTIFY is set
NOTIFY = "1"
TIMEOUT = "60"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "0"

inherit fullmetalupdate_package_container_image
inherit fullmetalupdate_push_container_to_ostree
