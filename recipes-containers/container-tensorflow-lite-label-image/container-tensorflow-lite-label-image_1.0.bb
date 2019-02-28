# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Container including tensorflow to run machine learning algorithm"
LICENSE = "CLOSED"

SRC_URI = "file://entry.sh"

FILES_${PN} += "/entry.sh"

RDEPENDS_${PN} += " \
    tensorflow-lite \
"

do_install(){
    install -m 0755 ${WORKDIR}/entry.sh ${D}/entry.sh
}
