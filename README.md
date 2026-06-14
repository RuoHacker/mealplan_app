# 献立管理アプリケーション (MealPlan App)

日常の献立管理や1週間のレシピ計画を効率化するためのSpring Bootアプリケーションです。

## 🚀 主な機能 (Features)

現在、以下の機能が利用可能です。
* **レシピ追加・削除機能**: お気に入りのレシピや新しい献立をシステムに登録・削除できます。
* **1週間のレシピ決定機能**: 自動、または手動で1週間のバランスの良い献立を計画・管理できます。

---

## 🛠️ 前提条件 / 環境設定 (Prerequisites)

ローカル環境でビルドおよび実行するには、以下のツールが必要です。

* **Java**: OpenJDK 21
* **Database**: MySQL 8.0
* **Build Tool**: Apache Maven 3.6.3
* ※ 今後のアップデートで Docker による環境構築をサポート予定です。

---

## 💻 起動・実行方法 (Getting Started)

環境に合わせて、以下のいずれかの方法でアプリケーションを起動してください。

### Pattern 1: ソースコードからビルドして実行

1. **リポジトリのクローン**
   ```bash
   git clone git@github.com:RuoHacker/mealplan_app.git
   cd mealplan_app
アプリケーションの起動

Bash
mvn spring-boot:run
💡 注意: # 献立管理アプリケーション (MealPlan App)

日常の献立管理や1週間のレシピ計画を効率化するためのSpring Bootアプリケーションです。

## 🚀 主な機能 (Features)

現在、以下の機能が利用可能です。
* **レシピ追加・削除機能**: お気に入りのレシピや新しい献立をシステムに登録・削除できます。
* **1週間のレシピ決定機能**: 自動、または手動で1週間のバランスの良い献立を計画・管理できます。

---

## 🛠️ 前提条件 / 環境設定 (Prerequisites)

ローカル環境でビルドおよび実行するには、以下のツールが必要です。

* **Java**: OpenJDK 21
* **Database**: MySQL 8.0
* **Build Tool**: Apache Maven 3.6.3
* ※ 今後のアップデートで Docker による環境構築をサポート予定です。

---

## 💻 起動・実行方法 (Getting Started)

環境に合わせて、以下のいずれかの方法でアプリケーションを起動してください。

### Pattern 1: ソースコードからビルドして実行

1. **リポジトリのクローン**
``` 
git clone git@github.com:RuoHacker/mealplan_app.git
cd mealplan_app
```
2. アプリケーションの起動
```
mvn spring-boot:run
```
💡 注意: 事前に MySQL 8.0 が起動しており、アプリケーションの設定ファイル（application.properties 等）に正しい接続情報が記載されていることを確認してください。

### Pattern 2: パッケージ（JARファイル）から実行

1. 配置されているパッケージ（[package名].zip）をダウンロードします。

2. ZIPファイルを解凍し、生成された [package名].jar があるディレクトリに移動します。

3. 以下のコマンドを実行してアプリケーションを起動します。 

### Pattern 3: Docker を使用した実行（💡 今後実装予定）

現在、DockerおよびDocker Composeを使用したコンテナ環境での実行を予定しています。

