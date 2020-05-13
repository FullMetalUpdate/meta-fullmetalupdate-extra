# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "TensorFlow Lite and Qt/QML: object detection example"
LICENSE = "GPLv3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

S = "${WORKDIR}/git"
SRC_URI = " \
    git://github.com/Witekio/RaspberryPi_TFLite_Qt.git \
"
SRCREV = "d421737f3db0a719c0ce3488432bf1cc536abec4"

DEPENDS = "qtquickcontrols2 \
           qtmultimedia \
           qttools-native \
           qtsensors \
           tensorflow-lite \
           "

require recipes-qt/qt5/qt5.inc

include ${PN}_${MACHINE}.inc

do_install() {
    install -d ${D}${datadir}/${P}
    install -m 0755 ${B}/TFLite_Qt_Pi ${D}${datadir}/${P}/qt-tflite
    cp ${S}/*.qml ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/assets ${D}${datadir}/${P}

    install -d ${D}${base_bindir}
    echo "#!/bin/sh" > ${D}${bindir}/qt-tflite
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${base_bindir}/qt-tflite
    echo "export QML2_IMPORT_PATH=${datadir}/${P}" >> ${D}${base_bindir}/qt-tflite

    echo "export QT_QPA_EGLFS_HEIGHT=768" >> ${D}${base_bindir}/qt-tflite
    echo "export QT_QPA_EGLFS_WIDTH=1024" >> ${D}${base_bindir}/qt-tflite
    echo "export QT_QPA_EGLFS_PHYSICAL_HEIGHT=150" >> ${D}${base_bindir}/qt-tflite
    echo "export QT_QPA_EGLFS_PHYSICAL_WIDTH=205" >> ${D}${base_bindir}/qt-tflite

    echo "export QT_QPA_PLATFORM=eglfs" >> ${D}${base_bindir}/qt-tflite

    echo "export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS='/dev/input/event0'" >> ${D}${base_bindir}/qt-tflite
    echo "cd ${datadir}/${P}/" >> ${D}${base_bindir}/qt-tflite
    echo "./qt-tflite" >> ${D}${base_bindir}/qt-tflite
    chmod +x ${D}${base_bindir}/qt-tflite
}

FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"



RDEPENDS_${PN} = "qtquickcontrols2-qmlplugins \
                  qtgraphicaleffects-qmlplugins"
