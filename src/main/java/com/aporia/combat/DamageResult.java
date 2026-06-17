package com.aporia.combat;

public class DamageResult {
  private final int damage;
  private final boolean critical;

  public DamageResult(int damage, boolean critical){
    this.damage = damage;
    this.critical = critical;
  }

  // 데미지 반환
  public int getDamage(){
    return damage;
  }

  // 치명타 적용 여부 반환
  public boolean isCritical(){
    return critical;
  }
}
