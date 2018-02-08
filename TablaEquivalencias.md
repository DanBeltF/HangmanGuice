| #CE |                                Clase de Equivalencia                               |      Tipo     |       Resultado       |
|:---:|:----------------------------------------------------------------------------------:|:-------------:|:---------------------:|
|  1  | gameScore = 100, correctCount ==> gameScore + 0, incorrectCount ==> gameScore - 10 | QuickTheories | gameScore >= 0        |
|  2  | gameScore = 0, correctCount ==> gameScore + 10, incorrectCount ==> gameScore - 5   | QuickTheories | gameScore >= 0        |
|  3  | gameScore = 0, correctCount ==> gameScore + 5^i, incorrectCount ==> gameScore - 8  | QuickTheories | 0 <= gameScore <= 500 |