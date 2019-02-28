# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:${THISDIR}/files:"

SRC_URI_append_imx6qdlsabresd = " \
    file://fullmetalupdate.bmp \
    file://Center-splash-screen-UBOOT.patch \
"

do_configure_append_imx6qdlsabresd() {
    cp ${WORKDIR}/fullmetalupdate.bmp ${S}/tools/logos/freescale.bmp
}
