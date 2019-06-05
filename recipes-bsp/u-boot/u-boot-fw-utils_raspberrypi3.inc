# Copyright (C) 2019 Witekio
# Released under the MIT license (see COPYING.MIT for the terms)
do_install_append () {
  cat >${D}${sysconfdir}/fw_env.config <<EOF

/mnt/bootpart/uboot.env 0x0000    0x4000

EOF
}
