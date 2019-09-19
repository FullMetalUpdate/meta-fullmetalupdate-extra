# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "QT Electric Vehicle Charging Station"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"
SRC_URI_stm32mp1-eval = " \
    git://github.com/pjgorka88/evcs-demo.git;branch=stm32mp1-eval;tag=v${PV}-stm32mp1-eval \
"

SRC_URI_stm32mp1-disco = " \
    git://github.com/Witekio/evcs-demo.git;branch=fullmetalupdate-demo;tag=v${PV}-step1 \
"

DEPENDS = "qtquickcontrols2 \
           qtmultimedia \
           qttools-native"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${datadir}/${P}
    install -m 0755 ${B}/DemoQtWS ${D}${datadir}/${P}
    cp ${S}/*.qml ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/Assets ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/Translation ${D}${datadir}/${P}
    install -d ${D}${base_bindir}

    cp ${THISDIR}/${MACHINE}/config.json ${D}${datadir}/${P}/config.json
    echo "#!/bin/sh" > ${D}${base_bindir}/DemoQtWS
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${base_bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_KMS_CONFIG=${datadir}/${P}/config.json" >> ${D}${base_bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_ALWAYS_SET_MODE=1" >> ${D}${base_bindir}/DemoQtWS
    echo "export QT_QPA_PLATFORM=eglfs" >> ${D}${base_bindir}/DemoQtWS
    
    echo "${datadir}/${P}/DemoQtWS" >> ${D}${base_bindir}/DemoQtWS
    chmod +x ${D}${base_bindir}/DemoQtWS
}

FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"


RDEPENDS_${PN} = "qtquickcontrols2-qmlplugins \
                  qtgraphicaleffects-qmlplugins"

PACKAGECONFIG_append-pn-qtbase = "libpng eglfs gl gles2 accessibility freetype fontconfig jpeg evdev"
PACKAGECONFIG_remove-pn-qtbase = "x11 xcb xkb xkbcommon-evdev"
PACKAGECONFIG_remove-pn-qtconnectivity = "bluez"
PACKAGECONFIG_remove-pn-qtsystems = "bluez"