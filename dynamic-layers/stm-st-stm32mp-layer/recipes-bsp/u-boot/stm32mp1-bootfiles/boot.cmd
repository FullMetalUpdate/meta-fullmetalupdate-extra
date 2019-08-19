env set bootfsmmc "0:4"
env set rootfsmmc "0:5"
env set bootargs_root "ostree_root=/dev/mmcblk0p5 root=/dev/ram0 ramdisk_size=8192"
env set bootargs_extra "rw rootfstype=ext4 consoleblank=0 vt.global_cursor_default=0 "
env set bootcmd_otenv "ext4load mmc ${rootfsmmc} $kernel_addr_r /boot/loader/uEnv.txt; env import -t $kernel_addr_r $filesize"
run bootcmd_otenv
env set bootargs ${bootargs} ${bootargs_root} ${bootargs_extra}
env set bootcmd_load_kernel "ext4load mmc ${rootfsmmc} $kernel_addr_r /boot${kernel_image}"
env set bootcmd_load_ramdisk "ext4load mmc ${rootfsmmc} $ramdisk_addr_r /boot${ramdisk_image}"
env set bootcmd_load_fdt "ext4load mmc ${bootfsmmc} $fdt_addr_r ${board_name}.dtb"
env set bootcmd_run "bootm ${kernel_addr_r} ${ramdisk_addr_r} ${fdt_addr_r}"
env set bootcmd "run bootcmd_load_fdt; run bootcmd_load_kernel; run bootcmd_load_ramdisk; run bootcmd_run"
run bootcmd