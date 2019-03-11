# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
WIC_CREATE_EXTRA_ARGS_append = "--no-fstab-update "

IMAGE_INSTALL_append = " \
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
