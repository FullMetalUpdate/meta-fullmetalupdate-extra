# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
LICENSE = "CLOSED"

S = "${WORKDIR}/git"
SRC_URI = " \
    git://github.com/Witekio/evcs-demo.git;tag=v${PV} \
"

DEPENDS = "qtdeclarative qtgraphicaleffects qttools-native qtmultimedia qtlocation qtquickcontrols qtvirtualkeyboard"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${datadir}/${P}
    install -m 0755 ${B}/DemoQtWS ${D}${datadir}/${P}
    cp ${S}/*.qml ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/Assets ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/Translation ${D}${datadir}/${P}

    install -d ${D}${bindir}
    echo "#!/bin/sh" > ${D}${bindir}/DemoQtWS
    echo "export QML_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/DemoQtWS
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/DemoQtWS
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${bindir}/DemoQtWS

    echo "export QT_QPA_EGLFS_HEIGHT=768" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_WIDTH=1024" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_PHYSICAL_HEIGHT=150" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_EGLFS_PHYSICAL_WIDTH=205" >> ${D}${bindir}/DemoQtWS

    echo "export QT_EGLFS_IMX6_NO_FB_MULTI_BUFFER=1" >> ${D}${bindir}/DemoQtWS
    echo "export QT_QPA_PLATFORM=eglfs" >> ${D}${bindir}/DemoQtWS

    echo "export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS='/dev/input/event0'" >> ${D}${bindir}/DemoQtWS

    echo "${datadir}/${P}/DemoQtWS" >> ${D}${bindir}/DemoQtWS
    chmod +x ${D}${bindir}/DemoQtWS
}

FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"

PACKAGECONFIG_append-pn-qtbase = "libpng eglfs gl gles2 accessibility freetype fontconfig jpeg evdev"
