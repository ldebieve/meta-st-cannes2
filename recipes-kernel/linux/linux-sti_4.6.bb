FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${PV}:"

include recipes-kernel/linux/linux-st.inc

SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-4.6.4.tar.xz;name=kernel"
SRC_URI[kernel.md5sum] = "b9f8183fa26621f9951ae522556c12d3"
SRC_URI[kernel.sha256sum] = "8568d41c7104e941989b14a380d167129f83db42c04e950d8d9337fe6012ff7e"

SRC_URI_append_stih410-b2260 = " \
    file://0001-V4l2-bdisp-hva-delta.patch \
    file://0002-SMAF.patch \
    file://0003-ST-FDMA.patch \
    file://0004-CLOCK.patch \
    file://0005-SOUND.patch \
    file://0006-DRM-KMS.patch \
    file://0007-REMOTEPROC-RPMSG.patch \
    file://0008-SECURITY.patch \
    file://0009-V4L2-CORE.patch \
    file://0010-Devicetree.patch \
    file://0011-Others.patch \
    file://0012-DEFCONFIG.patch \
    "
SRC_URI_append_st-xenomai = " \
    file://0001-V4l2-bdisp-hva-delta.patch \
    file://0002-SMAF.patch \
    file://0003-ST-FDMA.patch \
    file://0004-CLOCK.patch \
    file://0005-SOUND.patch \
    file://0006-DRM-KMS.patch \
    file://0007-REMOTEPROC-RPMSG.patch \
    file://0008-SECURITY.patch \
    file://0009-V4L2-CORE.patch \
    file://0010-Devicetree.patch \
    file://0011-Others.patch \
    file://0012-DEFCONFIG.patch \
    file://xenomai/0001-Ipipe-st-version.patch \
    file://xenomai/0002-Xenomai-driver-patch-for-v3.0.3.patch \
    file://xenomai/0003-Adaptation-patch-for-ST-soc.patch \
    file://xenomai/0004-Remove-unnecessary-configuration.patch \
    "
S = "${WORKDIR}/linux-4.6.4"
B = "${WORKDIR}/linux-${MACHINE}-standard-build"

LINUX_VERSION = "4.6"

PR = "r0"
PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "stih410-b2260|st-xenomai"

#---------------------------------------
# Defconfig
#
KERNEL_DEFCONFIG         = "multi_v7_defconfig"
KERNEL_CONFIG_FRAGMENTS  = "${THISDIR}/${PN}/${PV}/systemd.config"

#---------------------------------------
# Kernel Args
#
KERNEL_EXTRA_ARGS += "LOADADDR=${ST_KERNEL_LOADADDR} \
        TEXT_OFFSET=0x00008000 "
