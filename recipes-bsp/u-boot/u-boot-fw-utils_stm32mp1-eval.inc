# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
include u-boot-common.inc

SRC_URI += " \
    file://fw_env.config \
"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
