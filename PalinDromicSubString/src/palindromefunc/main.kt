package palindromefunc

fun main() {
    println(PalindromeFinder().getLongestPalindromicSubString("baba"))
}

class PalindromeFinder {
    private var subString: String = ""

    fun getLongestPalindromicSubString(str: String): String {
        return if (str.trim() != "" && str.isNotEmpty()) {
            subString = str[0].toString()
            var i = 0
            while (i < str.length) {
                subString = expandPalindrome(str.trim(), subString.trim(), i)
                i++
            }
            if (subString.length > 1) subString
            else "no Palindromic sub-string found"
        } else "no Palindromic sub-string found"
    }

    private fun expandPalindrome(str: String, subString: String, i: Int): String {
        var subStr = subString
        var left = i
        var right = i
        while (left >= 0 && right < str.length && str[left] == str[right]) {
            if (subStr.length <= str.substring(left, right + 1).length) {
                subStr = str.substring(left, right + 1)
            }
            left--
            right++
        }
        if (subStr.length < 2) {
            subStr = subString
            left = i
            right = i+1
            while (left >= 0 && right < str.length && str[left] == str[right]) {
                if (subStr.length <= str.substring(left, right + 1).length) {
                    subStr = str.substring(left, right + 1)
                }
                left--
                right++
            }
        }
        return subStr
    }
}