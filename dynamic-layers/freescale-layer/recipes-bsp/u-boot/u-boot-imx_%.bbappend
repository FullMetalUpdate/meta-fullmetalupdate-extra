# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:${THISDIR}/files:"

require ${PN}_${MACHINE}.inc

SRC_URI_append_imx8mqevk = " \
    file://fullmetalupdate.bmp \
    file://imx8mqevk_update.patch \
"

do_configure_append_imx8mqevk() {
    cp ${WORKDIR}/fullmetalupdate.bmp ${S}/tools/logos/freescale.bmp
}

