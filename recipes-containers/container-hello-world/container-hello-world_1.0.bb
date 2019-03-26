# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "A rootfs including busybox and a sh script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://entry.sh"

FILES_${PN} = "/entry.sh"

RDEPENDS_${PN} += " \
    busybox \
"

do_install() {
    install -m 0755 ${WORKDIR}/entry.sh ${D}/entry.sh
}
