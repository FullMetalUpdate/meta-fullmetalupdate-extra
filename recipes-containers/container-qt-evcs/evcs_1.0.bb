# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "QT Electric Vehicle Charging Station"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


S = "${WORKDIR}/git"
SRC_URI = " \
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

    install -d ${D}${bindir}
    echo "#!/bin/sh" > ${D}${bindir}/DemoQtWS
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/DemoQtWS
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/DemoQtWS

    echo "export QT_QPA_EGLFS_HEIGHT=768" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_WIDTH=1024" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_PHYSICAL_HEIGHT=150" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_PHYSICAL_WIDTH=205" >> ${D}${bindir}/DemoQtWS

    echo "export QT_QPA_PLATFORM=eglfs" >> ${D}${bindir}/DemoQtWS

    echo "export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS='/dev/input/event0'" >> ${D}${bindir}/DemoQtWS

    echo "${datadir}/${P}/DemoQtWS" >> ${D}${bindir}/DemoQtWS
    chmod +x ${D}${bindir}/DemoQtWS
}

FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"


RDEPENDS_${PN} = "qtquickcontrols2-qmlplugins \
                  qtgraphicaleffects-qmlplugins"

PACKAGECONFIG_append-pn-qtbase = "libpng eglfs gl gles2 accessibility freetype fontconfig jpeg evdev"
PACKAGECONFIG_remove-pn-qtbase = "x11 xcb xkb xkbcommon-evdev"
PACKAGECONFIG_remove-pn-qtconnectivity = "bluez"
PACKAGECONFIG_remove-pn-qtsystems = "bluez"