# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Boot files (bootscripts, etc.) for iMX.6 Sabre Lite Board"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit deploy

COMPATIBLE_MACHINE = "(mx6q|mx6dl|mx6sx|mx6sl)"
DEPENDS = "u-boot-mkimage-native"

S = "${WORKDIR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"
SRC_URI_append_sota = "\
    file://uEnv.txt \
    file://boot.cmd \
"

do_deploy() {
    install -d ${DEPLOYDIR}/${PN}

    mkimage -A arm -O linux -T script -C none -n "Ostree boot script" -d ${S}/boot.cmd ${DEPLOYDIR}/${PN}/boot.scr
    install -m 0755 ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/${PN}/uEnv.txt
}

addtask deploy before do_package after do_install
do_deploy[dirs] += "${DEPLOYDIR}/${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
