# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Hello World in a file"
LICENSE = "CLOSED"

SRC_URI = "file://entry.sh"

FILES_${PN} = "/entry.sh"

RDEPENDS_${PN} += " \
    busybox \
"

do_install() {
    install -m 0755 ${WORKDIR}/entry.sh ${D}/entry.sh
}
