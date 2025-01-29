# DisableKeyguardDimming

## 概要
- KeyGuard（=ロック画面）の壁紙のDimmingを無効にします
  - `ScrimState`の`mScrimBehindAlphaKeyguard`を一律0にしています
  - 結果的にAOSP Mods(PixelXpert)に近い(というか同じ?)場所を書き換えているっぽいので、そちらが動く環境なら概ね問題ないと思います

## 動作確認
- Motorola Edge40 (@r-ca)
  - Android 14
  - Security patch version: 2024/12/1
  - Build number: U1TLS34.115-16-1-7-1

## 既知の問題
- ロック画面だけならもう少し書き換える場所が少なくても済むかも？
- Android 15では動かない？
  - PixelXpertのコードを見た感じ??, これを組み込むとライセンスが変わってしまうので必要になったら別で作ります

## その他
- 自身のデバイスで動作したら教えていただけるとありがたいです！
- 開発環境
  - Android Studio Koala (2024.1.1)

## License
<details>
<summary>The Unlicense</summary>
  
本ソフトウェアは、パブリックドメインで公開されている無料で扱いやすいソフトウェアです。

本ソフトウェアは、商用または非商法を問わずいかなる目的においても、いかなる手段で、ソースコード形式またはコンパイル済みのバイナリを問わず、誰でも自由に複製、改変、公開、使用、コンパイル、販売、または頒布することができます。

著作権法を認める法域において、本ソフトウェアの著者または著者達は、本ソフトウェアのいかなる、また全ての著作権利権をパブリックドメインに献呈します。それは公衆の利益に広く貢献し、一方で我々の相続人及び継承者の不利益となります。この貢献の意図するところは、著作権法に基づき、本ソフトウェアの現在及び未来にわたる全ての権利を永久に放棄することを明らかにするためです。

本ソフトウェアは「現状のまま」提供されており、明示的または黙示的を問わず、特定の目的に対する商品適格性や適応性、及び非侵害の保証を含むがそれに制限されることなく、いかなる保証も致しません。著者はいかなる場合も、契約に沿った行為、不法行為、またはその他の行為にかかわらず、本ソフトウェアの使用または他の扱い方に起因して生じたいかなる請求、損害、またはその他の責任も一切負いません。

更なる情報が必要な場合には、http://unlicense.org/ を参照してください
</details>
