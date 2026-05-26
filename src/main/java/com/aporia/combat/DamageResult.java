package com.aporia.combat;

public class DamageResult {
  private final double damage;
  private final boolean critical;

  public DamageResult(double damage, boolean critical){
    this.damage = damage;
    this.critical = critical;
  }

  // 데미지 반환
  public double getDamage(){
    return damage;
  }

  // 치명타 적용 여부 반환
  public boolean isCritical(){
    return critical;
  }
}
