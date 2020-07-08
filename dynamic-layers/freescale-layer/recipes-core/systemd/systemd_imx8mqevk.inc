# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
SRC_URI_append = " \
    file://wired.network \
"

FILES_${PN} += " \
    ${nonarch_base_libdir}/systemd/network \
"

PACKAGECONFIG_append = " networkd"

do_install_append() {
    # The network files need to be in /usr/lib/systemd, not ${systemd_unitdir}...
    install -d ${D}${prefix}/lib/systemd/network/
    install -d ${D}/etc/systemd/network/
    install -m 0644 ${WORKDIR}/wired.network ${D}/etc/systemd/network/

    rm ${D}${libdir}/systemd/system/getty@.service
}
