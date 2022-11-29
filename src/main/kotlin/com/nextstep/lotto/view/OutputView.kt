package com.nextstep.lotto.view

import com.nextstep.lotto.domain.LottoResult
import com.nextstep.lotto.domain.LottoTickets
import com.nextstep.lotto.domain.Rank

object OutputView {
    fun printPurchaseAmountInputMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottoTicketMessage(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun printLastWeekWinningNumberMessage() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun printWinningStatMessage() {
        println("당첨 통계\n" + "---------")
    }

    fun printLottoTickets(lottoTickets: LottoTickets) {
        val sb = StringBuilder()
        lottoTickets.getLottoTickets().forEach {
            sb.append(it.getLottoNumbers().joinToString(separator = ", ", prefix = "[", postfix = "]")).append("\n")
        }

        println(sb)
    }

    fun printResult(result: LottoResult) {
        val sb = StringBuilder()
        Rank.values()
            .forEach {
                sb.append(it.matchCount).append("개 일치(").append(it.winningMoney).append(")- ")
                    .append(result.result[it] ?: 0)
                    .append("개\n")
            }

        println(sb)
    }

    fun printRatioResult(ratio: Double) {
        println("총 수익률은 $ratio 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
