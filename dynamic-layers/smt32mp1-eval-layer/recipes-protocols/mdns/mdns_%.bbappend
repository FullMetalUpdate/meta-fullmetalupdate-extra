

do_install_append () {
    rm -f ${D}${libdir}/libnss_mdns.so.2
}
