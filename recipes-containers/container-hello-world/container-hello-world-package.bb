# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "A minimal image containing busybox"
LICENSE = "CLOSED"

IMAGE_INSTALL = " \
    container-hello-world \
"

# Runc container configuration
RUNC_CONFIG = "${THISDIR}/${MACHINE}/hello-world-config.json"
# systemd container configuration
SYSTEMD_CONFIG = "${THISDIR}/files/hello-world-container.service"

# Set autostart to 1 if the container should be started automatically by systemd
AUTOSTART = "0"

# Set autoremove to 1 if the container should be removed automatically from the targets for the next update of the container
AUTOREMOVE = "0"

# Set screenused to 1 if the container uses the screen
SCREENUSED = "1"

inherit wiupdate_package_container_image
inherit wiupdate_push_container_to_ostree
