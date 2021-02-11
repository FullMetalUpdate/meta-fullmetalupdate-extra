# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"

SRC_URI_append_imx8mqevk = " \
    file://0001-Disable-busfreq-to-avoid-kernel-crash.patch \
"
