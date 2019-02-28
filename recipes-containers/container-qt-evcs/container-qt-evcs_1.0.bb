# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Example of QT5 application"
LICENSE = "CLOSED"

SRC_URI = "file://entry.sh"

FILES_${PN} = "/entry.sh"

RDEPENDS_${PN} += " \
    qtbase \
    qtbase-plugins \
    qtquickcontrols \
    qtquickcontrols-qmlplugins \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    evcs \
"

do_install() {
    install -m 0755 ${WORKDIR}/entry.sh ${D}/entry.sh
}

PACKAGECONFIG_remove-pn-qtconnectivity = "bluez"
PACKAGECONFIG_remove-pn-qtsystems = "bluez"
