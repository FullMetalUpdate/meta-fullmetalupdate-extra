# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WKS_FILES_imx6qdlsabresd = "fullmetalupdate-imx6qdlsabresd.wks.in"
WIC_CREATE_EXTRA_ARGS_append_imx6qdlsabresd = "--no-fstab-update "

IMAGE_INSTALL_append_imx6qdlsabresd = " \
    kernel-module-imx-gpu-viv \
    mdns \
    libnss-mdns \
    strace \
    qtquickcontrols \
    qtquickcontrols2 \
    qtdeclarative \
    qtquickcontrols2-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtdeclarative-qmlplugins \
    fontconfig \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
"
