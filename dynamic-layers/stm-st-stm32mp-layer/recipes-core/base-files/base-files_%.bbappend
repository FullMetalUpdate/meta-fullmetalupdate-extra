# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_prepend_fullmetalupdate-os := "${THISDIR}/stm32mp1:"

do_install_append_fullmetalupdate-os() {
    install -d ${D}/${APP_DIRECTORY}

    sed -e 's,@APP_DIRECTORY@,${APP_DIRECTORY},g' -i ${D}/${sysconfdir}/fstab
}
