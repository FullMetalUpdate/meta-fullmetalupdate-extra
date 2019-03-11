# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"

SRC_URI_append = " \
    file://0001-Enable-FIT-and-bootcount-on-RPi3.patch \
    file://0001-Add-Kcongig-entries-for-bootcount.patch \
    file://0001-Add-boot-partition-information.patch \
"
