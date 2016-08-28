DESCRIPTION         = "rtl8723bs MP SDIO WiFi Driver"
LICENSE             = "GPLv2"
LIC_FILES_CHKSUM    = "file://core/rtw_bt_mp.c;md5=394446478e990122f420219f2b3ee97f"
COMPATIBLE_MACHINE  = "(chip)"
S                   = "${WORKDIR}/git"

inherit module

SRC_URI = " \
    git://github.com/nextthingco/rtl8723bs.git;protocol=git;branch=chip/stable \
    file://rtl8723bs_mp_driver-quiet_debug_printk.patch \
"

SRCREV = "e749183f663009c5bd21767153ab1f9911283824"

# Custom Make options
RTL8723BS_MAKE_FLAGS += " \
    -DCONFIG_IOCTL_CFG80211 \
    -DRTW_USE_CFG80211_STA_EVENT \
    -DCONFIG_CONCURRENT_MODE \
    -DCONFIG_AUTO_AP_MODE \
    -DCONFIG_MP_INCLUDED \
"

EXTRA_OEMAKE += " \
    USER_EXTRA_CFLAGS='${RTL8723BS_MAKE_FLAGS}' \
    KSRC=${STAGING_KERNEL_DIR} \
    PREFIX=${D} \
"
