#!/bin/bash
#===============================================================================
#
#          FILE: make_stm32mp1_bootable.sh
#
#         USAGE: ./make_stm32mp1_bootable.sh [device]
#
#   DESCRIPTION: will correct the EFI file system labels and typecodes to make
#                it bootable on stm32.
#                For whatever reason, the labels need to match exactly
#
#===============================================================================

device=$1

echo "${device}"

# set partition type codes
sgdisk --typecode=1:8300 ${device}
sgdisk --typecode=2:8300 ${device}
sgdisk --typecode=3:8300 ${device}

# set partition labels
sgdisk --change-name=1:fsbl1 ${device}
sgdisk --change-name=2:fsbl2 ${device}
sgdisk --change-name=3:ssbl ${device}
