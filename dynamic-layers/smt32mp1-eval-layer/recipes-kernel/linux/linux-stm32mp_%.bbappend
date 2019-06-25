# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:${THISDIR}/files:"

SRC_URI_append_stm32mp1-eval = " \
    file://fullmetalupdate_splash_1024x768_ascii_224.ppm \
"

do_configure_prepend_stm32mp1-eval() {
    install -m 0644 ${WORKDIR}/fullmetalupdate_splash_1024x768_ascii_224.ppm ${S}/drivers/video/logo/logo_linux_clut224.ppm
}
