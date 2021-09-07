package com.basaki.codility;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.basaki.codility.BiggerIsGreater.biggerIsGreater;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class BiggerIsGreaterTest {

    @ParameterizedTest
    @CsvSource({"a, no answer", "ab, ba", "bb, no answer", "hefg, hegf", "dhck, dhkc", "dkhc, hcdk"})
    void testBiggerIsGreater0(String str, String expected) {
        assertEquals(expected, biggerIsGreater(str));
    }

    @Test
    void testBiggerIsGreater() {
        assertEquals("jfkaehlegowfggh", biggerIsGreater("jfkaehlegohwggf"));
    }

    @ParameterizedTest
    @CsvSource({"lmno, lmon", "dcba, no answer", "dcbb, no answer",
            "abdc, acbd", "abcd, abdc", "fedcbabcd, fedcbabdc"})
    void testBiggerIsGreater1(String str, String expected) {
        assertEquals(expected, biggerIsGreater(str));
    }


    @ParameterizedTest
    @CsvSource({"imllmmcslslkyoegymoa,	imllmmcslslkyoegyoam",
            "fvincndjrurfh,	fvincndjrurhf",
            "rtglgzzqxnuflitnlyit,	rtglgzzqxnuflitnlyti",
            "mhtvaqofxtyrz,	mhtvaqofxtyzr",
            "zalqxykemvzzgaka,	zalqxykemvzzgkaa",
            "wjjulziszbqqdcpdnhdo,	wjjulziszbqqdcpdnhod",
            "japjbvjlxzkgietkm,	japjbvjlxzkgietmk",
            "jqczvgqywydkunmjw,	jqczvgqywydkunmwj",
            "ehdegnmorgafrjxvksc,	ehdegnmorgafrjxvsck",
            "tydwixlwghlmqo,	tydwixlwghlomq",
            "wddnwjneaxbwhwamr,	wddnwjneaxbwhwarm",
            "pnimbesirfbivxl,	pnimbesirfbixlv",
            "mijamkzpiiniveik,	mijamkzpiiniveki",
            "qxtwpdpwexuej,	qxtwpdpwexuje",
            "qtcshorwyck,	qtcshorwykc",
            "xoojiggdcyjrupr,	xoojiggdcyjrurp",
            "vcjmvngcdyabcmjz,	vcjmvngcdyabcmzj",
            "xildrrhpca, xildrrpach",
            "rrcntnbqchsfhvijh, rrcntnbqchsfhvjhi",
            "kmotatmrabtcomu, kmotatmrabtcoum",
            "bnfcejmyotvw, bnfcejmyotwv",
            "dnppdkpywiaxddoqx, dnppdkpywiaxddoxq",
            "tmowsxkrodmkkra, tmowsxkrodmkrak",
            "jfkaehlegohwggf, jfkaehlegowfggh",
            "ttylsiegnttymtyx, ttylsiegnttymxty",
            "kyetllczuyibdkwyihrq, kyetllczuyibdkwyiqhr",
            "xdhqbvlbtmmtshefjf, xdhqbvlbtmmtshejff",
            "kpdpzzohihzwgdfzgb, kpdpzzohihzwgdgbfz"
    })
    void testExtra(String str, String expected) {
        assertEquals(expected, biggerIsGreater(str));
    }
    /*

kuywptftapaa	kuywptftpaaa
qfqpegznnyludrv	qfqpegznnyludvr
ufwogufbzaboaepslikq	ufwogufbzaboaepsliqk
jfejqapjvbdcxtkry	jfejqapjvbdcxtkyr
sypjbvatgidyxodd	sypjbvatgiodddxy
wdpfyqjcpcn	wdpfyqjcpnc
baabpjckkytudr	baabpjckkyturd
uvwurzjyzbhcqmrypraq	uvwurzjyzbhcqmryprqa
kvtwtmqygksbim	kvtwtmqygksbmi
ivsjycnooeodwpt	ivsjycnooeodwtp
zqyxjnnitzawipqsm	zqyxjnnitzawipsmq
blmrzavodtfzyepz	blmrzavodtfzyezp
bmqlhqndacv	bmqlhqndavc
phvauobwkrcfwdecsd	phvauobwkrcfwdedcs
vpygyqubqywkndhpzw	vpygyqubqywkndhwpz
yikanhdrjxw	yikanhdrwjx
vnpblfxmvwkflqobrk	vnpblfxmvwkflqokbr
pserilwzxwyorldsxksl	pserilwzxwyorldsxlks
qymbqaehnyzhfqpqprpl	qymbqaehnyzhfqpqrlpp
fcakwzuqlzglnibqmkd	fcakwzuqlzglnidbkmq
jkscckttaeifiksgkmxx	jkscckttaeifiksgkxmx
dkbllravwnhhfjjrce	dkbllravwnhhfjjrec
imzsyrykfvjt	imzsyrykfvtj
tvogoocldlukwfcajvix	tvogoocldlukwfcajvxi
cvnagtypozljpragvlj	cvnagtypozljprajglv
hwcmacxvmus	hwcmacxvsmu
rhrzcpprqccf	rhrzcpprqcfc
clppxvwtaktchqrdif	clppxvwtaktchqrfdi
qwusnlldnolhq	qwusnlldnolqh
yitveovrja	yitverajov
arciyxaxtvmfgquwb	arciyxaxtvmfgqwbu
pzbxvxdjuuvuv	pzbxvxdjuuvvu
nxfowilpdxwlpt	nxfowilpdxwltp
swzsaynxbytytqtq	swzsaynxbytyttqq
qyrogefleeyt	qyrogefletey
iotjgthvslvmjpcchhuf	iotjgthvslvmjpcchufh
knfpyjtzfq	knfpyjtzqf
tmtbfayantmwk	tmtbfayantwkm
asxwzygngwn	asxwzygnngw
rmwiwrurubt	rmwiwrurutb
bhmpfwhgqfcqfldlhs	bhmpfwhgqfcqfldlsh
yhbidtewpgp	yhbidtewppg
jwwbeuiklpodvzii	jwwbeuiklpodziiv
anjhprmkwibe	anjhprmkwieb
lpwhqaebmr	lpwhqaebrm
dunecynelymcpyonjq	dunecynelymcpyonqj
hblfldireuivzekegit	hblfldireuivzekegti
uryygzpwifrricwvge	uryygzpwifrriecgvw
kzuhaysegaxtwqtvx	kzuhaysegaxtwqtxv
kvarmrbpoxxujhvgpw	kvarmrbpoxxujhvgwp
hanhaggqzdpunkugzmhq	hanhaggqzdpunkugzmqh
gnwqwsylqeuqr	gnwqwsylqeurq
qzkjbnyvclrkmdtc	qzkjbnyvclrkmtcd
argsnaqbquv	argsnaqbqvu
obbnlkoaklcx	obbnlkoaklxc
ojiilqieycsasvqosycu	ojiilqieycsasvqosyuc
qhlgiwsmtxbffjsxt	qhlgiwsmtxbffjtsx
vvrvnmndeogyp	vvrvnmndeopgy
ibeqzyeuvfzb	ibeqzyeuvzbf
sajpyegttujxyx	sajpyegttujyxx
zmdjphzogfldlkgbchnt	zmdjphzogfldlkgbchtn
tbanvjmwirxx	tbanvjmwixrx
gmdhdlmopzyvddeqyjja	gmdhdlmopzyvddeyajjq
yxvmvedubzcpd	yxvmvedubzdcp
soygdzhbckfuk	soygdzhbckkfu
gkbekyrhcwc	gkbekyrhwcc
wevzqpnqwtpfu	wevzqpnqwtpuf
rbobquotbysufwqjeo	rbobquotbysufwqjoe
bpgqfwoyntuhkvwo	bpgqfwoyntuhkwov
schtabphairewhfmp	schtabphairewhfpm
rlmrahlisggguykeu	rlmrahlisggguykue
fjtfrmlqvsekq	fjtfrmlqvseqk
     */
}
