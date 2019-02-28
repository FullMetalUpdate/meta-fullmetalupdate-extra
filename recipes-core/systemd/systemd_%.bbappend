# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:${THISDIR}/files/:"

SRC_URI_append_imx6qdlsabresd = " \
    file://wired.network \
    file://udhcp.service \
"

PACKAGECONFIG_append_imx6qdlsabresd = " networkd"

do_install_append_imx6qdlsabresd() {
    # The network files need to be in /usr/lib/systemd, not ${systemd_unitdir}...
    install -d ${D}${prefix}/lib/systemd/network/
    install -d ${D}/etc/systemd/network/
    install -m 0644 ${WORKDIR}/wired.network ${D}/etc/systemd/network/

    rm ${D}${sysconfdir}/systemd/system/getty.target.wants/getty@tty1.service
}

FILES_${PN} += " \
    ${nonarch_base_libdir}/systemd/network \
    ${base_prefix}/bin/udhcp.service \
"

inherit systemd

SYSTEMD_SERVICE_${PN} = "udhcp.service"

do_install_append_imx6qdlsabresd() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644  ${WORKDIR}/udhcp.service ${D}${systemd_system_unitdir}
}
